.class public Lorg/drinkless/tdlib/TdApi$UpdateAccentColors;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAccentColors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x47597fba


# instance fields
.field public availableAccentColorIds:[I

.field public colors:[Lorg/drinkless/tdlib/TdApi$AccentColor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33729
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$AccentColor;[I)V
    .locals 0
    .param p1, "accentColorArr"    # [Lorg/drinkless/tdlib/TdApi$AccentColor;
    .param p2, "iArr"    # [I

    .line 33718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33719
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAccentColors;->colors:[Lorg/drinkless/tdlib/TdApi$AccentColor;

    .line 33720
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateAccentColors;->availableAccentColorIds:[I

    .line 33721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33725
    const v0, -0x47597fba

    return v0
.end method
