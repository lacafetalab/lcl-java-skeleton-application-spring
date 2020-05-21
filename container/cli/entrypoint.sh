#!/bin/bash

node /project/index.js

git config --global user.email "jguillermo@outlook.com"
git config --global user.name "Jose Guillermo"

cd /compare
git add .
#git commit -m "compare" --short
cp -R -p /render/application /compare/
git diff --color > /application/cli/diff/diff_color.txt
git diff > /application/cli/diff/diff.txt