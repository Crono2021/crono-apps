.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGiftCollection;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeGiftCollection"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x306d775b


# instance fields
.field public collectionId:I

.field public giftOwnerUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27685
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 27674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27675
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGiftCollection;->giftOwnerUsername:Ljava/lang/String;

    .line 27676
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGiftCollection;->collectionId:I

    .line 27677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27681
    const v0, -0x306d775b

    return v0
.end method
