.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftModel"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5112584f


# instance fields
.field public name:Ljava/lang/String;

.field public rarityPerMille:I

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41956
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41957
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p3, "i9"    # I

    .line 41945
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41946
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;->name:Ljava/lang/String;

    .line 41947
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 41948
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;->rarityPerMille:I

    .line 41949
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41953
    const v0, 0x5112584f

    return v0
.end method
