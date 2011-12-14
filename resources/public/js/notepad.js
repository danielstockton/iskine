$(document).ready(function() {
  var $protectdialog = $('#passform')
  .dialog({
    autoOpen: false,
    title: 'Password Protect'
  });

$('#passform').submit(function() {
  $.post(window.location.pathname + '/protect', $("#passform").serialize());
  $protectdialog.dialog('close');
  return false;
});

$('#protect').click(function() {
  $protectdialog.dialog('open');
  return false;
}); 

$('#notepad').on('focus', function() {
  $.post(window.location.pathname + '/update', { content: $(this).html() });
});

$('#notepad').on('blur', function() {
  $.post(window.location.pathname + '/update', { content: $(this).html() });
});

});
