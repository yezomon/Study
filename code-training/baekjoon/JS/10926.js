const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  
  let input = [];
  let answer = '';
  readline.on('line', function(line) {
    answer = line //input = line.split(' ').map(el => parseInt(el));
  }).on('close', function(){ //이 안에 솔루션 코드 작성
    console.log(answer+'??!');
    process.exit();
  });