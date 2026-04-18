.class public Lorg/drinkless/tdlib/TdApi$SearchWebApp;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchWebApp"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundWebApp;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4a0375cb


# instance fields
.field public botUserId:J

.field public webAppShortName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30749
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 30738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30739
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchWebApp;->botUserId:J

    .line 30740
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchWebApp;->webAppShortName:Ljava/lang/String;

    .line 30741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30745
    const v0, -0x4a0375cb

    return v0
.end method
