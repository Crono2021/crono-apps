.class public Lorg/drinkless/tdlib/TdApi$UpdateUnconfirmedSession;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUnconfirmedSession"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x159f774


# instance fields
.field public session:Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22215
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;)V
    .locals 0
    .param p1, "unconfirmedSession"    # Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;

    .line 22205
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22206
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnconfirmedSession;->session:Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;

    .line 22207
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22211
    const v0, -0x159f774

    return v0
.end method
