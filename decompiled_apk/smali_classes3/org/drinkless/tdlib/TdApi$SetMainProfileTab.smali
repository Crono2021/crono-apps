.class public Lorg/drinkless/tdlib/TdApi$SetMainProfileTab;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetMainProfileTab"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6326f0e7


# instance fields
.field public mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19806
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19807
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ProfileTab;)V
    .locals 0
    .param p1, "profileTab"    # Lorg/drinkless/tdlib/TdApi$ProfileTab;

    .line 19797
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19798
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetMainProfileTab;->mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

    .line 19799
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19803
    const v0, 0x6326f0e7

    return v0
.end method
