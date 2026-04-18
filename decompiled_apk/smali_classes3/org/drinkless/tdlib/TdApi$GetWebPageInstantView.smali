.class public Lorg/drinkless/tdlib/TdApi$GetWebPageInstantView;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetWebPageInstantView"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$WebPageInstantView;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x67cb94fd


# instance fields
.field public onlyLocal:Z

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26865
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 26854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26855
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetWebPageInstantView;->url:Ljava/lang/String;

    .line 26856
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$GetWebPageInstantView;->onlyLocal:Z

    .line 26857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26861
    const v0, 0x67cb94fd

    return v0
.end method
