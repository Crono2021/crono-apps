.class public Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestPoll;
.super Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "KeyboardButtonTypeRequestPoll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7164dcb8


# instance fields
.field public forceQuiz:Z

.field public forceRegular:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 27925
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 27914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 27915
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestPoll;->forceRegular:Z

    .line 27916
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestPoll;->forceQuiz:Z

    .line 27917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27921
    const v0, 0x7164dcb8

    return v0
.end method
