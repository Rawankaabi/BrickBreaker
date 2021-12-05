# BrickBreaker
Brick Breaker game is a project for IT214 course, Presented for Dr. Meshaiel Alsheail.

## Project Idea

Game where you shoot the ball to break bricks to win the game, each time you hit a brick the brick will destroyed and your score will increase by 10.
``` java 
if(ballrect.intersects(brickrect)) {
       map.setBrickval(0,i,j);
       totalbricks--;
       score += 10;
```
## Game Rules
The rule of BrickBreaker game is simple you should destroy the brick by the ball to win the game but if the ball fell down you lose.
- How to play:

    Press : space key to start the game.

    Press: D key to move right.

    Press : A key to move left.
    
## Output Sample

*Output1:


https://user-images.githubusercontent.com/94760374/144728750-57ddde64-eb95-490e-b823-ec01ef1b927b.mp4


*Output2:

![‏‏لقطة الشاشة (11)](https://user-images.githubusercontent.com/94760374/144728528-38670c61-06ae-4de9-98b6-78bc0b3c6d98.png)

*Output3:

![‏‏لقطة الشاشة (12)](https://user-images.githubusercontent.com/94760374/144728541-1dd09135-61a6-4f52-9bcd-4397fa6fa865.png)

## Reference
this code was inspired by [Awais Mirza](https://www.youtube.com/watch?v=K9qMm3JbOH0&ab_channel=AwaisMirza)
