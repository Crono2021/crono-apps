.class public Lorg/drinkless/tdlib/TdApi$CreateBusinessChatLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateBusinessChatLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessChatLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6eece2c0


# instance fields
.field public linkInfo:Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11059
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;)V
    .locals 0
    .param p1, "inputBusinessChatLink"    # Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;

    .line 11049
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11050
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateBusinessChatLink;->linkInfo:Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;

    .line 11051
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11055
    const v0, -0x6eece2c0

    return v0
.end method
