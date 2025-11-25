const posts= [
{
    "status": "Just finished my morning coffee! Ready to tackle the day ☕",

    "username": "cofeelover42",
    "like": false,
    "dislike": false,
    "comments": []

},
{
    "status": "Working on a new JavaScript project. Loving the challenge!",
    "username": "coderninja",
    "like": true,
    "dislike": false, 
    "comments": []
},
{
    "status": "Anyone else struggling with CSS grid? Need some help here!",
    "username": "webdev_newbie",
    "like": false,
    "dislike": false,
    "comments": []
  },
 {
    "status": "Finally deployed my first full-stack app! Feels amazing 🚀",
    "username": "fullstack_dev",
    "like": false,
    "dislike": false,
    "comments": []
  },
  {
    "status": "Monday blues hitting hard today... Need more motivation",
    "username": "workinghard123",
    "like": false,
    "dislike": false,
    "comments": []
  },
  {
    "status": "Learning React hooks and they're actually pretty cool!",
    "username": "react_learner",
    "like": false,
    "dislike": false,
    "comments": []
  },
   {
    "status": "Pizza for lunch again. I really need to start cooking 🍕",
    "username": "foodie_life",
    "like": false,
    "dislike": false,
    "comments":[]
  },
];
function postStatus(e) {
    e.preventDefault();
    const status = document.getElementById("status-post").value;
    const username = document.getElementById("username").value;
    const post = {
        "status": status,
        "username": username,
        "like": false,
        "dislike": false,
        "comments": []
    };
    posts.push(post);
    console.table(post);
    console.table(posts)
    viewPosts();
    saveToLocalStorage();
    document.getElementById("status-post").value = "";
    document.getElementById("username").value = "";
}

function viewPosts(){
    const statusData = document.getElementById("status-data");
    statusData.innerHTML = "";
    posts.slice().reverse().forEach((post, index) => {
        const actualIndex = post.reverse.length - 1 - index;
        const statusRow = document.createElement("div");
        statusRow.className = "post-container"
        statusRow.innerHTML = `
        <div class = "post-content">  
            <p class = "post-username"><strong>${post.username}</strong></p>
            <p class="post-status">${post.status}</p>
        </div>
        <div class= "post-actions"> 
            <button onclick="deletePost(${actualIndex})" class= "delete-btn"> Delete Post?
            </button>
            <button onclick= "toggleComments(${actualIndex})" class = "view-comments-btn"> View Comments (${post.comments.length})
            </button>
        </div> 
        <div id= "comments-section-${actualIndex}" class="comment-section" style="display: none;">
            <div class="add-comment-form">
                <input type= "text"
                id= "comment-username-${actualIndex}"
                placeholder= "User Name"
                class= "comment-input">
                </input> 
                <input type="text"
                id= "comment-text-${actualIndex}" 
                placeholder = "Write a Comment..."
                class= "comment-input">
                </input>
                <button onclick = "addComment(${actualIndex})" class= "add-comment-btn">Submit
                </button>
            </div>

            <div id="comments-list-${actualIndex}" class = "comment-list"> ${displayComments(post.comments, actualIndex)}
            </div>
        </div>
       `;
        statusData.appendChild(statusRow);
    });
}
function displayComments(comments, postIndex){
    if(comments.lenghth === 0){
        return '<p class = "no-comments">No comments...Be the first to comment!</p>';
    }
    return comments.map((comment, commentIndex) =>` 
        <div class= "comment-item">
            <div class = "comment-header">
                <strong>${comment.username}</strong>
                <button onclick="deletComment(${postIndex}, ${commentIndex})" class= "delete-comment-btn">
                    Delet Comment?
                </button>
            </div>
            <p class= "comment-text">${comment.text}</p>

        </div>
        `).join('');
}
function toggleComments(postIndex){
    const commentSection = document.getElementById(`comment-section-${postIndex}`);
    if(commentSection.style.display === "none"){
        commentSection.style.display = "block";
    } else {
        commentSection.style.display = "none";
    }
}

function addComment(postIndex) {
    const commentUsername = document.getElementById
    (`comment-username-${postIndex}`).value.trim();
    const commentText = document.getElementById
    (`comment-text-${postIndex}`).value.trin();

    if( commentUsername === "" || commentText === "") {
        alert ("Please enter username AND comment!");
        return;
    }
    const newComment = {
        username: commentUsername,
        text: commentText
    };

    posts[postIndex].comments.push(newComment);

    document.getElementById(`comment-username-${postIndex}`).value = "";
    document.getElementById(`comment-text-${postIndex}`).value = "";

    viewPosts();
    saveToLocalStorage();
    
    document.getElementById(`comments-section-${postIndex}`).style.display = "block";


}

function deletComment(postIndex, commentIndex){
    if (confirm("Delete this comment?")) {
        post[postIndex].comment.splice(commentIndex, 1);
        viewPosts();
        saveToLocalStorage();
        document.getElementById(`comment-section-${postIndex}`).style.display = "block";
    }
}

 function deletePost(postIndex){                                               
    if(confirm("Delete this post?")){

        posts.splice(postIndex, 1);
        
        viewPosts();
        saveToLocalStorage();
    }
}

const saveToLocalStorage = () => {
    localStorage.setItem("statusPosts", JSON.stringify(posts));
}
const getFromLocalStorage = () =>{
    const storedPost = localStorage.getItem("statusPosts");

    if (storedPost === null) return;
    posts.length = 0;
    JSON.parse(storedPost).forEach(post => {
        if(!post.comments){
            post.comments = [];
        }
    posts.push(post); 
    }); 
}

document.addEventListener("DOMContentLoaded", getFromLocalStorage);
document.addEventListener("DOMContentLoaded", viewPosts);