.class public Lorg/drinkless/tdlib/TdApi$AccentColor;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AccentColor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1d9da518


# instance fields
.field public builtInAccentColorId:I

.field public darkThemeColors:[I

.field public id:I

.field public lightThemeColors:[I

.field public minChannelChatBoostLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46449
    return-void
.end method

.method public constructor <init>(II[I[II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "iArr"    # [I
    .param p4, "iArr2"    # [I
    .param p5, "i11"    # I

    .line 46435
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46436
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AccentColor;->id:I

    .line 46437
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AccentColor;->builtInAccentColorId:I

    .line 46438
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AccentColor;->lightThemeColors:[I

    .line 46439
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AccentColor;->darkThemeColors:[I

    .line 46440
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$AccentColor;->minChannelChatBoostLevel:I

    .line 46441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46445
    const v0, -0x1d9da518

    return v0
.end method
