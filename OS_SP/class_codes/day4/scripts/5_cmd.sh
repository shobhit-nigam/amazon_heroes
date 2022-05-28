#!/bin/bash

name="roma"
echo "$name"
echo "before sparta \$? = $?"

sparta

echo "after sparta \$? = $?"

echo "$name"
echo "\$? = $?"
echo "after name \$? = $?"
