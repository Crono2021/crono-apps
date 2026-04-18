.class public Lorg/drinkless/tdlib/TdApi$PhotoSize;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PhotoSize"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5fea2c90


# instance fields
.field public height:I

.field public photo:Lorg/drinkless/tdlib/TdApi$File;

.field public progressiveSizes:[I

.field public type:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48346
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48347
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$File;II[I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "iArr"    # [I

    .line 48333
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48334
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PhotoSize;->type:Ljava/lang/String;

    .line 48335
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PhotoSize;->photo:Lorg/drinkless/tdlib/TdApi$File;

    .line 48336
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PhotoSize;->width:I

    .line 48337
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$PhotoSize;->height:I

    .line 48338
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PhotoSize;->progressiveSizes:[I

    .line 48339
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48343
    const v0, 0x5fea2c90

    return v0
.end method
