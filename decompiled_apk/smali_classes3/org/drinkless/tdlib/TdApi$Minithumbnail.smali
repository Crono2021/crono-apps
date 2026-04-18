.class public Lorg/drinkless/tdlib/TdApi$Minithumbnail;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Minithumbnail"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13952256


# instance fields
.field public data:[B

.field public height:I

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38766
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38767
    return-void
.end method

.method public constructor <init>(II[B)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "bArr"    # [B

    .line 38755
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38756
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Minithumbnail;->width:I

    .line 38757
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$Minithumbnail;->height:I

    .line 38758
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Minithumbnail;->data:[B

    .line 38759
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38763
    const v0, -0x13952256

    return v0
.end method
