<?php
include('connection.php');
if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $username = $_POST['enrollment'];
    $password = $_POST['password'];
    $check_user = mysqli_query($conn,"select * from user_registration where enno='$username' and  password='$password'");

if(mysqli_num_rows($check_user) > 0)
{   
    $result["Login"] = "1";
    echo json_encode($result);
    mysqli_close($conn);
}else{
    $result["Login"] = "0";
    echo json_encode($result);
    mysqli_close($conn);
}
}
?>
