.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUnknownDeepLink;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeUnknownDeepLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2549d7db


# instance fields
.field public link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15486
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15487
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15477
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15478
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUnknownDeepLink;->link:Ljava/lang/String;

    .line 15479
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15483
    const v0, 0x2549d7db

    return v0
.end method
