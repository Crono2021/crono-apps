.class public Lorg/drinkless/tdlib/TdApi$UpdateProfileAccentColors;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateProfileAccentColors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2412a6b8


# instance fields
.field public availableAccentColorIds:[I

.field public colors:[Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34789
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;[I)V
    .locals 0
    .param p1, "profileAccentColorArr"    # [Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;
    .param p2, "iArr"    # [I

    .line 34778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34779
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateProfileAccentColors;->colors:[Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;

    .line 34780
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateProfileAccentColors;->availableAccentColorIds:[I

    .line 34781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34785
    const v0, 0x2412a6b8    # 3.179992E-17f

    return v0
.end method
