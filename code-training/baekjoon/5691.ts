import * as readline from 'readline';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input: string[] = [];

rl.on('line', (line: string) => {
  input.push(line);
  const [a, b] = line.split(' ').map(Number);
  
  if (a === 0 && b === 0) {
    rl.close();
  }
});

rl.on('close', () => {
  solve();
  process.exit();
});

function solve() {
  for (let i = 0; i < input.length - 1; i++) {
    const [a, b] = input[i].split(' ').map(Number);
    
    // 여기에 두 수에 대한 연산 로직을 구현하세요
    const result = 3*Math.min(a,b)-(a + b);
    
    process.stdout.write(`${result}\n`);
  }
}
