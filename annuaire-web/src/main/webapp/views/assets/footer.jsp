		<div id="copyleft" class="text-center">développé par Dan et Nicolas</div>
    </div>
</div>
<!-- /container -->
<script src="${contextPath}/webapp/ressources/js/jquery.min.js"></script>
<script src="${contextPath}/webapp/ressources/js/moment.js"></script>
<script src="${contextPath}/webapp/ressources/js/bootstrap.min.js"></script>
<script src="${contextPath}/webapp/ressources/js/material.min.js"></script>
<script src="${contextPath}/webapp/ressources/js/datetimepicker.js"></script>
<script src="${contextPath}/webapp/ressources/js/ripples.min.js"></script>
<script src="${contextPath}/webapp/ressources/DataTables/datatables.min.js"></script>
<script>
	$.material.init();
	$('.datetimepicker').bootstrapMaterialDatePicker({time: false});
	$(document).ready(function() {
	    $('.table').DataTable( {
            "ordering": false,
            "language": {
                "url": "${contextPath}/DataTables/french.json"
            }
        } );
	} );
</script>
</body>
</html>