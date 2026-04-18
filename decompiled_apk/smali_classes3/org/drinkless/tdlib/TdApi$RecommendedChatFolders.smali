.class public Lorg/drinkless/tdlib/TdApi$RecommendedChatFolders;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecommendedChatFolders"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2c0f90f8


# instance fields
.field public chatFolders:[Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18385
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;)V
    .locals 0
    .param p1, "recommendedChatFolderArr"    # [Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;

    .line 18375
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18376
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RecommendedChatFolders;->chatFolders:[Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;

    .line 18377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18381
    const v0, -0x2c0f90f8

    return v0
.end method
