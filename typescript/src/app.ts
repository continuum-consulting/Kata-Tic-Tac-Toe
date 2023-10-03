import promptSync from "prompt-sync";

console.log("Hello world");

// const readline = require('readline').createInterface({
//     input: process.stdin,
//     output: process.stdout
// })
//
// readline.question('What is your name? ', (name: string) => {
//     console.log(`Hi ${name}`);
//     readline.close();
// })

const prompt = promptSync({ sigint: true });
const name = prompt("What is your name? ");
console.log(`Hi ${name}`);
