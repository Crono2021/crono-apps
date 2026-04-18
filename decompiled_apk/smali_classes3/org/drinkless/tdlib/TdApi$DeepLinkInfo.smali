.class public Lorg/drinkless/tdlib/TdApi$DeepLinkInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeepLinkInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6f1ba0fe


# instance fields
.field public needUpdateApplication:Z

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24865
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "z8"    # Z

    .line 24854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24855
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeepLinkInfo;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 24856
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$DeepLinkInfo;->needUpdateApplication:Z

    .line 24857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24861
    const v0, 0x6f1ba0fe

    return v0
.end method
