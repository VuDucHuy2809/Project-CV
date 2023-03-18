  <?php
        session_start();
        include '../connectdb/connect.php';
        if (isset($_GET['layout'])) {
            switch ($_GET['layout']) {
                case 'them':
                    require_once '../giaodien/them.php';
                    break;
                  case 'xoa':
                    require_once '../giaodien/xoa.php';
                    break;
                  case 'sua':
                    require_once '../giaodien/sua.php';
                    break;
                default :
                    require_once '../giaodien/admin.php';
                    break;
            }
        }
        else{
              require_once '../giaodien/admin.php';
        }
        ?>

