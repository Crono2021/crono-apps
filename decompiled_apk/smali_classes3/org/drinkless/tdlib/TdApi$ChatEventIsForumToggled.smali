.class public Lorg/drinkless/tdlib/TdApi$ChatEventIsForumToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventIsForumToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5a63d119


# instance fields
.field public isForum:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9979
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9969
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9970
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventIsForumToggled;->isForum:Z

    .line 9971
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9975
    const v0, 0x5a63d119

    return v0
.end method
