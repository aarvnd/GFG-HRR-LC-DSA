class Solution {
    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length , cols= classroom[0].length();
        int arr[][] = new int[rows][cols];
        int bitPosition[][] = new int[rows][cols];
        int bitCount = 0;
        int x = -1 , y = -1; 
        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                arr[i][j] = (char) classroom[i].charAt(j);
                if(arr[i][j]=='S')
                {
                    x = i ;
                    y = j;
                }
                else if(arr[i][j] =='L')
                {
                    bitPosition[i][j] = bitCount++;
                }
            }
        }
        int rowDelta[] ={-1,0,1,0},colDelta[]={0,1,0,-1};
        boolean visited[][][][] = new boolean[rows][cols][energy+1][1<<bitCount];
        int fullMask = (1<<bitCount)-1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y,energy,0,0));
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            if(temp.mask == fullMask) return temp.steps;
         
            if(temp.energy == 0) continue;
            for(int i = 0 ; i < 4;i++)
            {
                int nrow = temp.row + rowDelta[i];
                int ncol = temp.col + colDelta[i];
                if(nrow >=0 && nrow < rows && ncol >=0 && ncol < cols)
                {
                    if(arr[nrow][ncol]=='X') continue;
                    int newEnergy;
                    int newMask = temp.mask;
                    if(arr[nrow][ncol]=='R')
                    {
                        newEnergy = energy;
                    }
                    else if(arr[nrow][ncol]=='L')
                    {
                        newEnergy = temp.energy-1;
                        newMask |= (1<< bitPosition[nrow][ncol]);
                    }
                    else 
                    {
                        newEnergy = temp.energy -1;
                    }
                    if(visited[nrow][ncol][newEnergy][newMask]==false)
                    {
                        visited[nrow][ncol][newEnergy][newMask] = true;
                        q.add(new Pair(nrow , ncol ,  newEnergy , newMask,temp.steps+1));
                    }
                } 
            }
        }
        return -1;
    }
}

class Pair 
{
    int row , col ,energy , mask,steps;
    Pair(int row ,int col , int energy , int mask,int steps )
    {
        this.row = row ;
        this.col = col;
        this.energy = energy;
        this.mask = mask;
        this.steps = steps;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna