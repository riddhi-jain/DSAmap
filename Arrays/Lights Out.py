'''Lenny is playing a game on a 3 × 3 grid of lights. In the beginning of the game all lights are switched on. Pressing any of the lights will toggle it and all side-adjacent lights. The goal of the game is to switch all the lights off. We consider the toggling as follows: if the light was switched on then it will be switched off, if it was switched off then it will be switched on.

Lenny has spent some time playing with the grid and by now he has pressed each light a certain number of times. Given the number of times each light is pressed, you have to print the current state of each light.

Input
The input consists of three rows. Each row contains three integers each between 0 to 100 inclusive. The j-th number in the i-th row is the number of times the j-th light of the i-th row of the grid is pressed.

Output
Print three lines, each containing three characters. The j-th character of the i-th line is "1" if and only if the corresponding light is switched on, otherwise it's "0".'''

matrix = [[0]*5 for _ in range(5)]
for i in range(1,4):
  matrix[i][1:4] = [int(x) for x in input().split()]

for i in range(1,4):
  for j in range(1,4):
    print((1+ matrix[i][j] + matrix[i-1][j] + matrix[i+1][j] + matrix[i][j-1] + matrix[i][j+1]) % 2, end = '')
  print()
