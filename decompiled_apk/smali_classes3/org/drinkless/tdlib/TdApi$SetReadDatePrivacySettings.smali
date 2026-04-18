.class public Lorg/drinkless/tdlib/TdApi$SetReadDatePrivacySettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetReadDatePrivacySettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1d7086b6


# instance fields
.field public settings:Lorg/drinkless/tdlib/TdApi$ReadDatePrivacySettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19915
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReadDatePrivacySettings;)V
    .locals 0
    .param p1, "readDatePrivacySettings"    # Lorg/drinkless/tdlib/TdApi$ReadDatePrivacySettings;

    .line 19905
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19906
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetReadDatePrivacySettings;->settings:Lorg/drinkless/tdlib/TdApi$ReadDatePrivacySettings;

    .line 19907
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19911
    const v0, 0x1d7086b6

    return v0
.end method
