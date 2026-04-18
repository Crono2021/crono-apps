.class public Lorg/drinkless/tdlib/TdApi$SetDefaultGroupAdministratorRights;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetDefaultGroupAdministratorRights"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x65577768


# instance fields
.field public defaultGroupAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19645
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;)V
    .locals 0
    .param p1, "chatAdministratorRights"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 19635
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19636
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetDefaultGroupAdministratorRights;->defaultGroupAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 19637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19641
    const v0, 0x65577768

    return v0
.end method
