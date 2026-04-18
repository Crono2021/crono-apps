.class public Lorg/drinkless/tdlib/TdApi$SetSupergroupMainProfileTab;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetSupergroupMainProfileTab"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e5fc65c


# instance fields
.field public mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32049
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ProfileTab;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "profileTab"    # Lorg/drinkless/tdlib/TdApi$ProfileTab;

    .line 32038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32039
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupMainProfileTab;->supergroupId:J

    .line 32040
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupMainProfileTab;->mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

    .line 32041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32045
    const v0, 0x4e5fc65c    # 9.385797E8f

    return v0
.end method
