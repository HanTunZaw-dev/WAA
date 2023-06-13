import React from 'react'
import Post from './Post'

const Posts = ({ list, clickItem }) => {

    const handleClick = (id) => {
        clickItem(id);
        console.log(id);
        console.log(clickItem(id));
    }
    return (
        <div>
            <div className='post-box-container'>
                {
                    list.map(s =>
                        <Post key={s.id} id={s.id} title={s.title} author={s.author} handleClick={(id) => handleClick(id)} />
                    )
                }
            </div>
            
        </div>
    )
}

export default Posts