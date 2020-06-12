<?php
include('connection.php');
if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $user = $_POST['user'];
    $data = mysqli_query($conn,"select * from user_activity where enrollment='$user'");

    if(mysqli_num_rows($data) > 0)    
    {   
        while($rows = mysqli_fetch_assoc($data)){
            $result[] = $rows;
        }
        echo json_encode($result);
        mysqli_close($conn);
    }else{
        $result["Data"] = "No Expense Added";
        echo json_encode($result);
        mysqli_close($conn);
    }


    
    
}

?>