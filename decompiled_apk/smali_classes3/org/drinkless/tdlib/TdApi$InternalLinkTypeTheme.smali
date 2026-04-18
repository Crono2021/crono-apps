.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeTheme;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeTheme"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xbfa07f9


# instance fields
.field public themeName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15468
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15469
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15459
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15460
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeTheme;->themeName:Ljava/lang/String;

    .line 15461
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15465
    const v0, -0xbfa07f9

    return v0
.end method
