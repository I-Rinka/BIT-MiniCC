#!/bin/bash
a='./my_paraphrase.txt'
b='./target_paraphrase.txt'
cat ./1_scanner_test.tokens| awk -F ',' '{print substr($2,index($2,"'\''"),length($2)) $3}' > $a
cat ./target_token.tokens| awk -F ',' '{print substr($2,index($2,"'\''"),length($2)) $3}' > $b
diff $a $b