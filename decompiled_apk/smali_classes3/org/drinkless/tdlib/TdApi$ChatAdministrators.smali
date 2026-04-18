.class public Lorg/drinkless/tdlib/TdApi$ChatAdministrators;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatAdministrators"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ebb07c3


# instance fields
.field public administrators:[Lorg/drinkless/tdlib/TdApi$ChatAdministrator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9709
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatAdministrator;)V
    .locals 0
    .param p1, "chatAdministratorArr"    # [Lorg/drinkless/tdlib/TdApi$ChatAdministrator;

    .line 9699
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9700
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatAdministrators;->administrators:[Lorg/drinkless/tdlib/TdApi$ChatAdministrator;

    .line 9701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9705
    const v0, -0x7ebb07c3

    return v0
.end method
