.class public Lorg/drinkless/tdlib/TdApi$PageBlockChatLink;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockChatLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x621ed8bb


# instance fields
.field public accentColorId:I

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

.field public title:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 44455
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;ILjava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "chatPhotoInfo"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;
    .param p3, "i9"    # I
    .param p4, "str2"    # Ljava/lang/String;

    .line 44442
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 44443
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockChatLink;->title:Ljava/lang/String;

    .line 44444
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockChatLink;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

    .line 44445
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockChatLink;->accentColorId:I

    .line 44446
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockChatLink;->username:Ljava/lang/String;

    .line 44447
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44451
    const v0, 0x621ed8bb

    return v0
.end method
