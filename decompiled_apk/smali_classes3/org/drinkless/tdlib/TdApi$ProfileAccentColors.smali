.class public Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProfileAccentColors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2386e2bf


# instance fields
.field public backgroundColors:[I

.field public paletteColors:[I

.field public storyColors:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39096
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 39097
    return-void
.end method

.method public constructor <init>([I[I[I)V
    .locals 0
    .param p1, "iArr"    # [I
    .param p2, "iArr2"    # [I
    .param p3, "iArr3"    # [I

    .line 39085
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 39086
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;->paletteColors:[I

    .line 39087
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;->backgroundColors:[I

    .line 39088
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;->storyColors:[I

    .line 39089
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39093
    const v0, -0x2386e2bf

    return v0
.end method
