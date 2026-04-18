.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeLanguagePack;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeLanguagePack"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5678f294


# instance fields
.field public languagePackId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15379
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15369
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15370
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeLanguagePack;->languagePackId:Ljava/lang/String;

    .line 15371
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15375
    const v0, -0x5678f294

    return v0
.end method
