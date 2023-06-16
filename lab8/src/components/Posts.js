
import React, {useState, useEffect} from 'react'
import Post from './Post'
import axios from 'axios'

export default function Posts({ fetchFlag, clickedItem }) {
    const [posts, setPosts] = useState([])
    const fetchPosts = () => {
        axios.get(`/posts`)
            .then(res => {
                console.log(res)
                setPosts(res.data)
            })
            .catch(err => {
                console.log(err)
            })
    }

    useEffect(() => {
        fetchPosts();
    }, [fetchFlag])

    const handleClick = (id) => {
        clickedItem(id)
        console.log(`Posts : ${id}`)
    }
    return (
        <div>
            <div className='post-box-container'>
                {
                    posts.map(s =>
                        <Post key={s.id} id={s.id} title={s.title} author={s.author} handleClick={handleClick} />
                    )
                }
            </div>

        </div>
    )
}
