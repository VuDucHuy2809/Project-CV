import React from 'react'

function MessageBox(props) {
  return (
    <div variant={props.variant || 'info'}>
        <div  class="alert alert-primary" role="alert">{props.children}</div>
    </div>
  )
}

export default MessageBox