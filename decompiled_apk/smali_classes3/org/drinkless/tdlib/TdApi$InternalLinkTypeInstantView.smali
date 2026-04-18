.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeInstantView;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeInstantView"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x69e4df3f


# instance fields
.field public fallbackUrl:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27705
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 27694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27695
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeInstantView;->url:Ljava/lang/String;

    .line 27696
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeInstantView;->fallbackUrl:Ljava/lang/String;

    .line 27697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27701
    const v0, 0x69e4df3f

    return v0
.end method
