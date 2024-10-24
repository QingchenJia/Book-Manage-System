// cipherUtil.js

const keyString = '1234567890123456';  // 密钥
const ivString = 'abcdefghijklmnop';   // 向量
const algorithm = { name: 'AES-CBC', iv: new TextEncoder().encode(ivString) }; // 加密模式和 IV

async function getKey() {
  const keyBuffer = new TextEncoder().encode(keyString);
  return await crypto.subtle.importKey(
    'raw',
    keyBuffer,
    'AES-CBC',
    false,
    ['encrypt', 'decrypt']
  );
}

async function encrypt(input) {
  const key = await getKey();
  const encoder = new TextEncoder();
  const data = encoder.encode(input);
  const cipherText = await crypto.subtle.encrypt(algorithm, key, data);
  return btoa(String.fromCharCode(...new Uint8Array(cipherText))); // Base64 编码
}

async function decrypt(cipherText) {
  const key = await getKey();
  const data = new Uint8Array(atob(cipherText).split("").map(char => char.charCodeAt(0)));
  const decrypted = await crypto.subtle.decrypt(algorithm, key, data);
  return new TextDecoder().decode(decrypted);
}