<?php

namespace SoftUniBlogBundle\Controller;

use SoftUniBlogBundle\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use SoftUniBlogBundle\Entity\Article;
use SoftUniBlogBundle\Form\ArticleType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use Symfony\Component\HttpFoundation\Request;

class ArticleController extends Controller
{
    /**
     * @param Request $request
     *
     * @Route ("/article/create", name="article_create")
     * @Security ("is_granted('IS_AUTHENTICATED_FULLY')")
     *
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $article = new Article();
        $form = $this->createForm(ArticleType::class, $article);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $article->setAuthor($this->getUser());
            $em = $this->getDoctrine()->getManager();
            $em->persist($article);
            $em->flush();

            return $this->redirectToRoute('blog_index');
        }

        return $this->render('article/create.html.twig',
            array('form' => $form->createView()));
    }

    /**
     * @Route("/article/{id}", name="article_view")
     * @param $id
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function viewArticle($id)
    {
        $article = $this->getDoctrine()->getRepository(Article::class)->find($id);

        if  ($article == null) {
            return $this->redirectToRoute('blog_index');
        }

        return $this->render('article/article.html.twig', ['article' => $article]);
    }

    /**
     * @Route("/articles/own", name="own_articles")
     * @@return \Symfony\Component\HttpFoundation\Response
     */
    public function myArticles()
    {
        /** @var User $currentUser */
        $currentUser = $this->getUser();
        $currentUserArticles = $currentUser->getArticles();

        return $this->render('blog/index.html.twig', ['articles' => $currentUserArticles]);
    }
}
