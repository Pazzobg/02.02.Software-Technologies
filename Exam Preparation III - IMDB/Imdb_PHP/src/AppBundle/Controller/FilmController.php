<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Film;
use AppBundle\Form\FilmType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class FilmController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        $filmRepo = $this->getDoctrine()->getRepository(Film::class);
        $films = $filmRepo->findAll();

        return $this->render('film/index.html.twig', ['films' => $films]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $film = new Film();

        $form = $this->createForm(FilmType::class, $film);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($film->getName() === null ||
            $film->getGenre() === null ||
            $film->getDirector() === null ||
            $film->getYear() === null) {
                return $this->redirectToRoute('create');
            }

            $em = $this->getDoctrine()->getManager();
            $em->persist($film);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('film/create.html.twig', array('form' => $form->createView()));
	}

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        $filmForEdit = $this->getDoctrine()->getRepository(Film::class)->find($id);

        if ($filmForEdit === null) {
            return $this->redirectToRoute('index');
        }

        $form = $this->createForm(FilmType::class, $filmForEdit);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($filmForEdit->getName() === null ||
                $filmForEdit->getGenre() === null ||
                $filmForEdit->getDirector() === null ||
                $filmForEdit->getYear() === null) {
                return $this->redirectToRoute('index');
            }

            $em = $this->getDoctrine()->getManager();
            $em->merge($filmForEdit);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('film/edit.html.twig', ['film' => $filmForEdit, 'form' => $form->createView()]);
    }
    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        $filmToDelete = $this->getDoctrine()->getRepository(Film::class)->find($id);

        if ($filmToDelete === null) {
            return $this->redirectToRoute('index');
        }

        $form = $this->createForm(FilmType::class, $filmToDelete);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($filmToDelete);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('film/delete.html.twig', ['film' => $filmToDelete, 'form' => $form->createView()]);
    }
}
