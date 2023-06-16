
import React, {useState, useEffect} from 'react'
import Post from './Post'
import axios from 'axios'

/*
lab 8 
export default function Posts({ fetchFlag, clickedItem }) {
    */
export default function Posts({ fetchFlag, clickedItem }) {
    console.log('RENDER POSTS')
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
    }, [fetchFlag])//<AddPost> က အသစ်ထည့်ပြီးတာနဲ့ res ပြန်လာရင် changeFetchFlag() ကို ခေါ်လိုက်တာ ဒီမှာဖမ်းထားပြီး ပြန်load ပေးတာ 

    /* lab 8 - clicked Item id pass via props Post > Posts > Dashboard
    const handleClick = (id) => {//Post(Child) က ပြန်pass လိုက်တဲ့ id ကိုဖမ်း, 
        clickedItem(id)//this id is bind back to HOC handleClick prop, which is Dashboard
        console.log(`Posts : ${id}`)
    }
    */
    return (
        <div>
            <div className='post-box-container'>
                {
                    posts.map(s =>
                        <Post key={s.id} id={s.id} title={s.title} author={s.author} />
                        /* lab 8 - clicked Item id pass via props Post > Posts > Dashboard
                        <Post key={s.id} id={s.id} title={s.title} author={s.author} handleClick={handleClick} />
                        */
                        //handleClick={(id) => handleClick(id)} 
                        //- 1st id is return from child component (Post)
                        //- 2nd id is pass that id to handlClick func above 
                    )
                }
            </div>

        </div>
    )
}
