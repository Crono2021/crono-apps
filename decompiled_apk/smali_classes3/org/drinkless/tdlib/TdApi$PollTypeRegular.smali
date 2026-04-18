.class public Lorg/drinkless/tdlib/TdApi$PollTypeRegular;
.super Lorg/drinkless/tdlib/TdApi$PollType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PollTypeRegular"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2638f022


# instance fields
.field public allowMultipleAnswers:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17790
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PollType;-><init>()V

    .line 17791
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 17781
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PollType;-><init>()V

    .line 17782
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PollTypeRegular;->allowMultipleAnswers:Z

    .line 17783
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17787
    const v0, 0x2638f022

    return v0
.end method
