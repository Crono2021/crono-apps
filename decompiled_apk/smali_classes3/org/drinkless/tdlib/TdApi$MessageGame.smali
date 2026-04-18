.class public Lorg/drinkless/tdlib/TdApi$MessageGame;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x423968a


# instance fields
.field public game:Lorg/drinkless/tdlib/TdApi$Game;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16512
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16513
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Game;)V
    .locals 0
    .param p1, "game"    # Lorg/drinkless/tdlib/TdApi$Game;

    .line 16503
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16504
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGame;->game:Lorg/drinkless/tdlib/TdApi$Game;

    .line 16505
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16509
    const v0, -0x423968a

    return v0
.end method
