import javax.swing.tree.TreeNode;

class segmentTree{

    public static void Segmenttree(int[] a,int[] tree,int start,int end,int treenode){
        if(start==end)
        {
            tree[treenode]=a[start];
            return;
        }
        int mid = (start+end)/2;
        Segmenttree(a,tree,start,mid,2*treenode);
        Segmenttree(a,tree,mid+1,end,2*treenode+1);

        tree[treenode] = tree[2*treenode] + tree[2*treenode+1];
    }

    public static void Update(int[] a,int[] tree,int treenode,int start, int end,int index,int value){

        if(start==end){
            a[index] += value;
            tree[treenode] += value;
            return;
        }
        else{
            int mid = (start+end)/2;

            if(start <= index && index <= mid)
            {
                Update(a, tree, 2*treenode, start, mid,index,value);
            }
            else
            {
                Update(a, tree, 2*treenode +1 , mid+1, end,index,value);
            }
            tree[treenode] = tree[2*treenode] + tree[2*treenode+1];
        }

    }


    public static int Q(int[] tree,int l,int r,int start,int end,int treenode){

        if(r < start || end < l)
            return 0;

        if(l <= start && end <= r)
            return tree[treenode];

        int mid = (start + end) / 2;
        int p1 = Q(tree,l,r,start,mid,2*treenode);
        int p2 = Q(tree,l,r,mid+1,end,2*treenode+1);
        return (p1 + p2);
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        int n = a.length;
        int[] tree = new int[n*2];

        Segmenttree(a,tree,0,n-1,1);

        Update(a,tree,1,0,n-1,8,1);
        System.out.println(Q(tree,0,n-1,0,n-1,1));
        for(int p:tree)
            System.out.print(p + " ");
    }
}