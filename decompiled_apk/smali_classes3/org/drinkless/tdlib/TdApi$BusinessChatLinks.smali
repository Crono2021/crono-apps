.class public Lorg/drinkless/tdlib/TdApi$BusinessChatLinks;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessChatLinks"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b6779c


# instance fields
.field public links:[Lorg/drinkless/tdlib/TdApi$BusinessChatLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9205
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$BusinessChatLink;)V
    .locals 0
    .param p1, "businessChatLinkArr"    # [Lorg/drinkless/tdlib/TdApi$BusinessChatLink;

    .line 9195
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9196
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLinks;->links:[Lorg/drinkless/tdlib/TdApi$BusinessChatLink;

    .line 9197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9201
    const v0, 0x4b6779c

    return v0
.end method
