.class public Lorg/drinkless/tdlib/TdApi$ChatBoost;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6940334e


# instance fields
.field public count:I

.field public expirationDate:I

.field public id:Ljava/lang/String;

.field public source:Lorg/drinkless/tdlib/TdApi$ChatBoostSource;

.field public startDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46735
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$ChatBoostSource;II)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I
    .param p3, "chatBoostSource"    # Lorg/drinkless/tdlib/TdApi$ChatBoostSource;
    .param p4, "i10"    # I
    .param p5, "i11"    # I

    .line 46721
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46722
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoost;->id:Ljava/lang/String;

    .line 46723
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoost;->count:I

    .line 46724
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatBoost;->source:Lorg/drinkless/tdlib/TdApi$ChatBoostSource;

    .line 46725
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatBoost;->startDate:I

    .line 46726
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChatBoost;->expirationDate:I

    .line 46727
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46731
    const v0, -0x6940334e

    return v0
.end method
